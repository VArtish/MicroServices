jQuery(function ($) {
    let stompClient;

    $("#js-connect").click(function () {
        if (!stompClient) {
            console.info('try connect')
            const socket = new SockJS("http://localhost:8080/wsp");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function () {

                stompClient.subscribe('/currency/list', function (response) {
                    console.log('Got ' + response);
                    $("#js-notifications").append(JSON.parse(response.body).text + ' ')
                });

                console.info('connected!')
            });
        }
    });

    $('#js-disconnect').click(function () {
        if (stompClient) {
            stompClient.disconnect();
            stompClient = null;
            console.info("disconnected :-/");
        }
    });
});