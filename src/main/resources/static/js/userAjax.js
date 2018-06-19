(function () {
    var app = angular.module('myApp', []);

    app.controller("showDate", function ($scope, $http) {
        $scope.data;
        $scope.currentPage = 1;
        $scope.where = "";
        $scope.count = 0;


        $scope.request = function (page) {
            $http.post("/user/userall", {currentPage: page, where: $scope.where}).success(function (data) {
                $scope.data = data.list;
                $scope.currentPage = data.currentPage;
                $scope.where = data.where;
                $scope.count = data.count;
            }).error(function () {
                alert("失败")
            })
        }
        /**
         * 首页
         */
        $scope.request(1);
        /***
         * 下一页
         */
        $scope.next = function () {
            if ($scope.count > $scope.currentPage)
                $scope.currentPage += 1;
            $scope.request($scope.currentPage);
        }
        /***
         * 上一页
         */
        $scope.prve = function () {
            if (1 < $scope.currentPage)
                $scope.currentPage -= 1;
            $scope.request($scope.currentPage);
        }
        /***
         * 尾页
         */
        $scope.last = function () {
            $scope.request($scope.count);
        }
        /**
         * 删除
         */
        $scope.del = function (id) {
            if (confirm("您确定要删除吗?")) {
                $.get("/user/delete", {"id": id}, function (data) {
                    if (data.msg == "1") {
                        location.reload(true);
                    } else {
                        alert(data.error)
                    }
                }, "json")
            }
        }
    });
})();



