var serverUrl = "http://localhost:60001/";

$(document).ready(function () {

        $.ajax({
            url: serverUrl+"employee",
            type: "GET",
            success: updateView
        });

        $('#textinput').keyup(function () {
            var filteredProperty = $("input:radio[name='radios']:checked").val()
            var searchValue = $('#textinput').val();
            var restUrl;
            if (filteredProperty == "id") {
                restUrl = serverUrl + "employee/" + searchValue;
            } else {
                restUrl = serverUrl + "employee?tel=" + searchValue;
            }
            $.ajax({
                url: restUrl,
                type: "GET",
                success: updateView
            });
        });
    }
);

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