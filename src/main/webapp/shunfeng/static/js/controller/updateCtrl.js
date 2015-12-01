ctrls.controller('updateController',['$scope','$state','AddMoving','$stateParams','GetOneMoving','UpdateMoving'
  ,function($scope,$stateParams,AddMoving,$state,GetOneMoving,UpdateMoving){
    // console.log($stateParams);
    // console.log($state);

    console.log($state.id);
    $scope.moving = GetOneMoving.get({id:$state.id},function(){
      console.log($scope.moving);
    })




}]);
