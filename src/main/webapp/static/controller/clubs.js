/**
 * Created by lx199 on 2016/6/3.
 */
var app = angular.module("myApp",[]);
app.controller("ClubController", function($scope) {
    $scope.clubs = [
        {"champ": "英超", "club": "阿森纳足球俱乐部"},
        {"champ": "意甲", "club": "尤文图斯足球俱乐部"},
    ]
})