ctrls.controller('addController',['$scope','AddMoving'
  ,function($scope,AddMoving){

    $scope.region = [
    {id:1,name:"海淀区"},
    {id:2,name:"朝阳区"},
    {id:3,name:"西城区"},
    {id:4,name:"东城区"},
    {id:5,name:"丰田区"},
    {id:6,name:"大兴区"},
    {id:7,name:"石景山"}];

    $scope.currentRegion = $scope.region[0];
    if(typeof($scope.carType) === "undefined"){
      $scope.carType = 3;
    }

    var d = new Date();

    $scope.test = function(){
      var d = new Date($scope.time);

      var moving =
      {
        region: $scope.currentRegion.id,
        carType: $scope.carType,
        areaCode:$scope.areaCode,
        telephone:$scope.telephone,
        time:d.valueOf(),
        contact:$scope.contact
      }
      console.log(moving);
      console.log($scope.contact);
      console.log($scope.time);
      console.log(d.valueOf());

      AddMoving.save(moving,function(data){
        alert("成功");
      },function(error){
        alert("失败")；
      })

    }

    $scope.testSelect = function(area){
      console.log(area);
    }




}]);
