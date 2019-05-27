var week = [0];
var client = [20];
var webSocket = new WebSocket("wss://localhost:8443/demotss_war/chartsocket");

var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: week,
        datasets: [
            {
                data: client,
                label: "Klienci",
                borderColor: "#5cb85c",
                fill: false
            }
        ]
    },
    options: {
        title: {
            display: true,
            text: 'Ilość nowych klientów w przeciągu każdego tygodnia. (WEBSOCKET)',
            fontSize: 18
        }
    }
});

function init(){
    setInterval(send,2000);
}

function send(){
    webSocket.send("");
}

function close(){
    webSocket.close();
}

webSocket.onopen = function(){ console.log("connect websocket")};
webSocket.onclose = function(){ console.log("close websocket")};

webSocket.onmessage = function (event) {
    console.log(event.data);
    var weeks = week[week.length-1];
    week.push(weeks+7);
    client.push(event.data);
    myChart.update();
};