// app.js

//Main Angular script file for application

//create a module with injected modules in brackets
var routeApp = angular.module('route',['ngResource', 'ui.router', 'nourControllers', 'nourConfig']);

// router config
routeApp.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider, $routeProvider, $httpProvider) {

  $urlRouterProvider
  .otherwise('/');

  // $httpProvider.responseInterceptors.push('SecurityHttpInterceptor');

  $stateProvider
      //main page
      .state('main', {
          url: '/',
          templateUrl: "partials/main.html",
          controller: "mainController"
      })
      //add page
      .state('add', {
          url: '/',
          templateUrl: "partials/add.html",
          controller: "addController"
      })
      //update page
      .state('update', {
          url: '/update/:id',
          templateUrl: "partials/update.html",
          controller: "updateController"
      })


}]);
