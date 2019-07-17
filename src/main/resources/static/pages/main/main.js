var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        // id: '',
        // name: ''
    },
    methods: {
        saveUserFn: function () {
            var _this = this;
            $.ajax({
                type: "GET",
                url: "http://localhost:9999/saveUser",
                success: function () {
                    _this.message = "Success!";
                },
                error: function () {
                    _this.message = "failed!";
                }
            });
        },

        /**
         * 读取用户图片
         */
        readUserFn: function () {
            var _this = this;
            $.ajax({
                type: "GET",
                url: "http://localhost:9999/readPhoto",
                success: function () {
                    _this.message = "Success!";
                },
                error: function () {
                    _this.message = "failed!";
                }
            });
        }

    }
});