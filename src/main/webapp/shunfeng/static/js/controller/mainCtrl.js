//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'movingServices']);

ctrls.controller('mainController',['$scope','GetMoving',function($scope,GetMoving){

  $scope.name = "查询";

  GetMoving.get({page:0,size:3},function(data){
    console.log(data);
    $scope.movingInfo = data;

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


  })
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
