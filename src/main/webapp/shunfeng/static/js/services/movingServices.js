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

  /*
  Get a Moving
  */
  movingServices.factory('GetOneMoving',['$resource','config',
    function($resource,config){
      return $resource(config.HOST + "movingInfo/:id",
        {id:'@_id'},
        {}
    );
    }])

  /*
  update a Moving
  */
  movingServices.factory('UpdateMoving',['$resource','config',
    function($resource,config){
      return $resource(config.HOST + "movingInfo/:id?status:=stauts",
        {id:'@_id',status:'@_status'},
        {update:{
          method:'PUT'
        }}
    );
    }])
