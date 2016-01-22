/**
 * Created by nareshm on 6/11/2015.
 */

var pageController = function (/* $scope, $location, $http */) {
    console.log("Page Controller reporting for duty.");

    // Activates the Carousel
    $('.carousel').carousel({
        interval: 5000
    });

    // Activates Tooltips for Social Links
    $('.tooltip-social').tooltip({
        selector: "a[data-toggle=tooltip]"
    })
};

var homeController = function ($http) {
    var self = this;
    self.items = [];
    self.resp = {};

    self.addCustomer = function () {
        console.log("Add customer details:" + self.customer)
        $http.post('/addCustomer', self.customer)
            .then(function (response) {
                self.resp = response.data;
                console.log(self.resp);
                self.message = "Success";
            }, function (response) {
                self.message = "Failure to add";
            });
    };

};
var searchController = function ($http) {
    var self = this;
    self.items = [];
    self.resp = {};

    self.getCustomer = function () {
        console.log("Get customer details:" + self.customer)
        $http.post('/getCustomer', self.customer)
            .then(function (response) {
                self.resp = response.data;
                console.log(self.resp);
                self.message = "Success";
            }, function (response) {
                self.message = "Failure to add";
            });
    };

};