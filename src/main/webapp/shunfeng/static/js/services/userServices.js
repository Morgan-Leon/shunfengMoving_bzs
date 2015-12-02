var userServices = angular.module('userServices',['ngResource', "nourConfig"]);
/*
Get User By Name
*/
userServices.factory('GetUserByName',['$resource','config'
,function($resource,config){
  return $resource(config.HOST + "user/:name",
    {name:"@_name"},{}
);

}]);
