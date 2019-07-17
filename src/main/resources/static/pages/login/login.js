var vm = new Vue({
    el: "#formAsync",
    data: {
        imgUrl: "../../../themes/images/init.jpg",
        userId: "",
        loadInfo:""
    },
    methods: {
        // changeURL: function () {
        //     var _this = this;
        //     _this.imgUrl = "../../../themes/images/cache_" + _this.userId + ".jpg"
        //     console.log("test...")
        // }
        changeURL: function () {
            var _this = this;
            _this.loadInfo = "增在加载中，请稍等......";
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "http://localhost:9999/getUserDetailById",
                data: $('#formAsync').serialize(),
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        _this.loadInfo = "加载成功!";
                        _this.imgUrl = "../../../themes/images/cache_" + _this.userId + ".jpg";
                        // alert("获取成功");
                    } else {
                        _this.loadInfo = "图片加载失败!";
                    }
                },
                error: function () {
                    alert("操作异常!");
                }
            });
        }


    }
});