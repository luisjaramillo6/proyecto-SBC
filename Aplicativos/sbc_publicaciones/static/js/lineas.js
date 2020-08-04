Morris.Bar({
    element: 'graph1',
    data: [
      {x: 'Institute', y: 89},
      {x: 'Laboratory', y: 471},
      {x: 'University', y: 907}
    ],
    xkey: 'x',
    ykeys: ['y'],
    labels: ['Cantidad'],
    resize:true,

    barColors: function (row, series, type) {
        if (type === 'bar') {
          var red = Math.ceil(255 * row.y / this.ymax);
          return 'rgb(' + red + ',0,0)';
        }
        else {
          return '#000';
        }
      }

  });

  Morris.Donut({
    element: 'graph2',
    resultado = (valor/1467)*100
    data: [
      {value: 61.82, label: 'University', formatted: resultado },
      {value: 32.10, label: 'Laboratory', formatted: resultado },
      {value: 6.07, label: 'Institute', formatted: resultado },

    ],
    formatter: function (x, data) { return data.formatted; }
  });
