var express = require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io")(server);
var fs = require("fs");
server.listen(process.env.PORT || 3000);
// 1.
// app.get("/", function(req, res) {
//     res.sendFile(__dirname + "/index.html");
// });
console.log("Server running");

// 2.
// io.sockets.on('connection', function(socket) {
//     console.log("Co thiet bi vua ket noi");
//     socket.on('client-send-data', function(data) {
//         console.log("Server nhan: " + data);
//         io.sockets.emit("/", { noidung: data });
//     });
// });

var arrayUser = []; // Mảng chứa các User
var tontai = true; // Biến để kiểm tra user có tồn tại không
io.sockets.on('connection', function(socket) {
    console.log("Co thiet bi vua ket noi");
    socket.on('client-register-user', function(data) {
        if (arrayUser.indexOf(data) == -1) {
            // Không tồn tại User trong danh sách đã đăng ký
            arrayUser.push(data);
            tontai = false;
            console.log("Dang ky thanh cong user: " + data);
            // Gán tên user cho client socket, data chình là tên user.
            socket.un = data; //hàm un gán tên lại cho socket.
            // Gửi danh sách user về tất cả các máy.
            io.sockets.emit('server-send-user', { danhsach: arrayUser });
        } else {
            console.log("Da ton tai user: " + data);
            tontai = true;
        }
        // Gởi kết quả đăng ký đến user đã đăng ký (1 client).
        io.sockets.emit('server-send-data', { ketqua: tontai });
    });
    socket.on('client-send-chat', function(noiDung) {
        console.log(socket.un + ": " + noiDung);
        io.sockets.emit('server-send-chat', { chatComent: socket.un + ": " + noiDung });
    });
});