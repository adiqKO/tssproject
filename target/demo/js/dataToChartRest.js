var week = [0];
var client = [12];

var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: week,
        datasets: [
            {
                data: client,
                label: "Klienci",
                borderColor: "#0000ff",
                fill: false
            }
        ]
    },
    options: {
        title: {
            display: true,
            text: 'Ilość nowych klientów w przeciągu każdego tygodnia. (REST)',
            fontSize: 18
        }
    }
});

function load(){
    $.ajax({
        url : 'webapi/chartRest',
        dataType: "json"
    }).done(function(res) {
        var weeks = week[week.length-1];
        week.push(weeks+7);
        console.log(res);
        client.push(res.amountOfClient);
        myChart.update();
    })
}

$(document).ready(function(){
    setInterval(load,2000);
});