//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'movingServices','pageableServices']);

ctrls.controller('mainController',['$scope','$stateParams','GetMoving','Pageable',function($scope,$stateParams,GetMoving,Pageable){

  $scope.name = "查询";

  // GetMoving.get({page:0,size:3},function(data){
  //   console.log(data);
  //   $scope.movingInfo = data;
  //
  //   }
    $scope.movingInfo;

    $scope.createPageable = function (){
        $scope.searchPageable = new Pageable();

        $scope.searchPageable.size = 4;
        $scope.searchPageable.page = 1;

        $scope.searchPageable.arguments="";
        // Set the startPage and length of number page array
        // console.log($scope.searchArguments);

        $scope.searchPageable.pageNumbers.startPage = 1;
        $scope.searchPageable.pageNumbers.content.length = 4;
        // Set the placeholder elements
        $scope.searchPageable.placeHolders.placeHoldersElement = {title: ""};

        // Build the pageable object
        $scope.searchPageable.build(GetMoving);

        $scope.searchPageable.showPage($stateParams.page === undefined ? 1 : $stateParams.page);
        console.log($scope.searchPageable);
        $scope.movingInfo = $scope.searchPageable.entities;
    }

    $scope.createPageable();


    $scope.isAble = function(iterm){
      if (iterm.status === "已结束") {
        return true;
      }
      else {
        return false;
      }
    }

    $scope.getHref = function(item){
      if ($scope.isAble(item)) {
        return "";
      }
      else {
        return "#/update/"+item.id;
      }
    }
    // $scope.isAble = function(item){
    //   console.log(item);
    //   var name = "#btn" + item.id;
    //
    // }

    // $("@optBtn").on('click', function(event) {
    //   event.preventDefault();
    //   /* Act on the event */
    //   window.location.href="#/update/"+$scope.movingInfo.content.id;
    // });


  // })
}]);

ctrls.filter('formatRegion', function () {
    return function (input) {
        // if (input.length > 6)
        //     return input.substring(0, 6) + '...';
        // else
        //     return input;
        switch (input) {
          case 1: return "海淀区";
          case 2: return "朝阳区";
          case 3: return "西城区";
          case 4: return "东城区";
          case 5: return "丰田区";
          case 6: return "大兴区";
          case 7: return "石景山";

          default: return "";
        }

    }
});

ctrls.filter('formatCarType', function () {
    return function (input) {
        // if (input.length > 6)
        //     return input.substring(0, 6) + '...';
        // else
        //     return input;
        switch (input) {
          case 1: return "金杯";
          case 2: return "皮卡";
          case 3: return "厢式货车";
          case 4: return "1041货车";

          default: return "";
        }

    }
});
