ctrls.controller('updateController',['$scope','$state','AddMoving','$stateParams','GetOneMoving','UpdateMoving'
  ,function($scope,$stateParams,AddMoving,$state,GetOneMoving,UpdateMoving){
    // console.log($stateParams);
    // console.log($state);



    console.log($state.id);
    $scope.moving = GetOneMoving.get({id:$state.id},function(){
      console.log($scope.moving);
      $scope.currentState = $scope.moving.status;

      $scope.update = function(){
        console.log($scope.currentState);
        $scope.moving.status = $scope.currentState;
        $scope.um = new UpdateMoving();
        $scope.um.$update({id:$state.id,status:$scope.currentState},function(){
          alert("成功");
        },function(error){
          alert("失败");
        });
      }
    })



}]);
