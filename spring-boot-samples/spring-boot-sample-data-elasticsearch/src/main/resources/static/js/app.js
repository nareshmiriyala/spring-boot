/**
 * AngularJS Tutorial 1
 * @author Nick Kaye <nick.c.kaye@gmail.com>
 */

/**
 * Main AngularJS Web Application
 */
var app = angular.module('customerSearchApp', [
    'ngRoute'
]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        // Home
        .when("/home", {templateUrl: "/pages/home.html", controller: "homeCntrl"})
        .when("/welcome", {templateUrl: "/pages/welcome.html", controller: "welcomeCntrl"})
        .when("/result", {templateUrl: "/pages/result.html", controller: "resultCntrl"})
        .when("/search", {templateUrl: "/pages/search.html", controller: "searchCntrl"})
        // else 404
        .otherwise("/404", {templateUrl: "/pages/404.html", controller: "PageCtrl"});
}]);


/**
 * Controls all other Pages
 */
app.controller('PageCtrl', pageController);
app.controller('homeCntrl', homeController);
app.controller('welcomeCntrl', welcomeController);
app.controller('resultCntrl', resultController);
app.controller('searchCntrl', searchController);
