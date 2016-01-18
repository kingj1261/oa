$(function () {
    lineChart('#LineData1', 'spline');
    lineChart1('#LineData2', 'line');
    pieChart('#PieData', 'pie');
});





var data = [];
function  zon(n) {
    return  n < 10 ? '0' + n : '' + n;
}
for (var i = 1; i < 13; i++) {

    data.push('2015-' + zon(i));
}
function lineChart1(id, type) {
    var charts = {
        colors: ['#a463a7', '#e96e9a', '#efd26a', '#dbac74', '#93b964', '#30a0ea',
            , '#ddf2ad', '#cca9ad', 'rgb(0,205,205)', 'rgb(0,215,215)'],
        chart: {
            type: type},
        //版权credits
        credits: {
            enabled: false
        },
        //标题
        title: {
            text: null},
        legend: {
            enabled: true},
        series: [
            {
                name: '新客户行销',
                lineWidth: '1px',
                color: '#ffb400',
                data: [245, 278, 187, 378, 178, 108, 258, 328, 158, 278, 280, 270]
            },
            {
                name: '老客户回访',
                color: '#71ca85',
                lineWidth: '1px',
                data: [45, 78, 87, 78, 78, 18, 58, 28, 58, 78, 80, 27]
            }

        ],
        tooltip: {
            formatter: function () {
                var s = '<b>' + this.x + '行销' + '</b>';
                $.each(this.points, function () {
                    s += '<br/>' + this.series.name + ': ' + this.y + '点';
                });
                return s;
            },
            borderColor: '#ccc',
            shared: true},
        xAxis: {
            title: '积分总量趋势图',
            categories: data},
        yAxis: {
            title: '积分总量趋势图',
            lineWidth: 1,
            min: 0,
            labels: {
                formatter: function () {
                    return this.value + '元';
                }
            }
        }
    }

    $(id).highcharts(charts);
}
function lineChart(id, type) {
    var charts = {
        colors: ['#a463a7', '#e96e9a', '#efd26a', '#dbac74', '#93b964', '#30a0ea',
            , '#ddf2ad', '#cca9ad', 'rgb(0,205,205)', 'rgb(0,215,215)'],
        chart: {
            type: type},
        //版权credits
        credits: {
            enabled: false
        },
        //标题
        title: {
            text: null},
        legend: {
            enabled: true},
        series: [
            {
                name: '行销',
                lineWidth: '1px',
                color: '#54c06b',
                data: [245, 278, 187, 378, 178, 108, 258, 328, 158, 278, 280, 270]}
        ],
        tooltip: {
            formatter: function () {
                var s = '<b>' + this.x + '行销' + '</b>';
                $.each(this.points, function () {
                    s += '<br/>' + this.series.name + ': ' + this.y + '点';
                });
                return s;
            },
            borderColor: '#ccc',
            shared: true},
        xAxis: {
            title: '积分总量趋势图',
            categories: data},
        yAxis: {
            title: '积分总量趋势图',
            lineWidth: 1,
            min: 0,
            labels: {
                formatter: function () {
                    return this.value + '元';
                }
            }
        }
    }

    $(id).highcharts(charts);
}
;
function pieChart(id, type) {
    $(id).highcharts({
        colors: ['#a463a7', '#e96e9a', '#efd26a', '#dbac74', '#93b964', '#30a0ea',
            , '#ddf2ad', '#cca9ad', 'rgb(0,205,205)', 'rgb(0,215,215)'],
        chart: {
            options3d: {
                alpha: 0.2
            }
        }, //版权credits
        credits: {
            enabled: false,
            href: 'https://www.baidu.com/',
            text: 'https://www.baidu.com/',
            position: {
                align: 'right',
                x: -10,
                verticalAlign: 'bottom',
                y: -10
            },
            style: {
                color: '#f00',
                fontSize: '13px',
                fontWeight: 'bold'
            }
        }, //标题
        title: {
            text: '积分总量趋势图',
            useHTML: true,
            floating: false, style: {fontSize: '14px',
                fontWeight: 'bold',
                fontFamily: '微软雅黑',
                display: 'none'
            }
        },
        legend: {
            align: 'center',
            verticalAlign: 'bottom',
            enabled: true
        },
        plotOptions: {
            pie: {
                allowPointSelect: true, cursor: 'pointer', showInLegend: true,
                dataLabels: {enabled: true, color: '#000000', connectorColor: '#000000', format: '<b>{point.name}</b>: {point.percentage:.1f} %'}}
        },
        series: [
            {
                name: '行销业务',
                type: type,
                data: [
                    ['李四', 45.0], ['李四', 26.8],
                    ['四覆盖', 26.8],
                    ['张五', 8.5],
                    ['牛二', 8.5],
                    ['达尔', 10.7]
                ]
            }
        ],
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>',
            style: {
                color: '#707070'
            }
        }
    });
}
