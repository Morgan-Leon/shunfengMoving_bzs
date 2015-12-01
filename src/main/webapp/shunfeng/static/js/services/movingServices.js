var movingServices = angular.module('movingServices',['ngResource', "nourConfig"]);

/*
Get All Moving
*/
movingServices.factory('GetMoving',['$resource','config',
  function($resource,config){
    return $resource(config.HOST + "movingInfo?page:=page&size=:size",
            {page:'@_page',size:'@_size'}, {}
        );
  }])

/*
Add a Moving
*/
movingServices.factory('AddMoving',['$resource','config',
  function($resource,config){
    return $resource(config.HOST + "movingInfo",
      {},{}
  );
  }])
