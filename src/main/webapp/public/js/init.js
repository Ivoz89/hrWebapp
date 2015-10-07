$(document).ready(function () {
    $.ajax({
        url: "http://localhost:60001/employee",
    type: "GET",
    success : updateView
});

$('#textinput').keyup(function () {
    var option = $("input:radio[name='radios']:checked").val()
    var query = $('#textinput').val();
    var url;
    if (option == "id") {
        url = "http://localhost:60001/employee/" + query;
    } else {
        url = "http://localhost:60001/employee?tel=" + query;
    }
    $.ajax({
        url: url,
        type: "GET",
        success: updateView
    });
});
})
;

function updateView(data) {
    var tbody = document.createElement('tbody');
    tbody.id = "tableBody";
    if (data.length == undefined) {
        tbody.appendChild(createTR(data))
    } else {
        data.forEach(function (elem) {
            tbody.appendChild(createTR(elem));
        });
    }
    $("#tableBody").replaceWith(tbody);
}

var propertyNames = ['id', 'name', 'surname', 'telephoneNumber'];

function createTR(elem) {
    var tr = document.createElement('tr');
    propertyNames.forEach(function (propertName) {
        var td = document.createElement('td');
        td.appendChild(document.createTextNode(elem[propertName]));
        tr.appendChild(td);
    });
    var dobTd = document.createElement('td');
    dobTd.appendChild(document.createTextNode(new Date(elem.dob)));
    tr.appendChild(dobTd);
    return tr;
}