//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'movingServices']);

ctrls.controller('mainController',['$scope','GetMoving',function($scope,GetMoving){

  $scope.name = "查询";

  GetMoving.get({page:0,size:3},function(data){
    console.log(data);
    $scope.movingInfo = data;

  })
}]);

// ctrls.filter('formatRegion',function(){
//   return function(in){
    // switch (in) {
    //   case 1: return "海淀区";
    //   case 2: return "朝阳区";
    //   case 3: return "西城区";
    //   case 4: return "东城区";
    //   case 5: return "丰田区";
    //   case 6: return "大兴区";
    //   case 7: return "石景山";
    //
    //   default: return "";
    // }
  // };
// });

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
