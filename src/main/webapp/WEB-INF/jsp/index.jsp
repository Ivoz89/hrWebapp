<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    function doAjaxPost() {
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        var name = $('#name').val();
        $.ajax({
            url: "/board/" + name,
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success: function (board) {
                var tableRef = document.getElementById('boards').getElementsByTagName('tbody')[0];
                var newRow = tableRef.insertRow(tableRef.rows.length);
                var nameCell = newRow.insertCell(0);
                var a = document.createElement('a');
                a.href = "board/" + escapeHtml(board.name);
                a.text = escapeHtml(board.name);
                nameCell.appendChild(a);
                var sizeCell = newRow.insertCell(1);
                sizeCell.appendChild(document.createTextNode(0));
            }
        });
    }

    function escapeHtml(unsafe) {
        return unsafe
                .replace(/&/g, "&amp;")
                .replace(/</g, "&lt;")
                .replace(/>/g, "&gt;")
                .replace(/"/g, "&quot;")
                .replace(/'/g, "&#039;");
    }

$( document ).ready(function() {
console.log("ready");
  $('#textinput').keyup(function() {
         var option = $("input:radio[name='radios']:checked").val()
             var query = $('#textinput').val();
             var url;
         if(option == "id") {
            url= "/employee/"+query;
         } else {
            url= "/employee?tel="+query;
         }
         $.ajax({
                 url: url,
                 type: "GET",
                 success: function (data) {
                    var tbody = document.createElement('tbody');
                    tbody.id = "tableBody";
                    console.log(data);
                    if(data.length == undefined) {
                        tbody.appendChild(createTR(data))
                    } else {
                        data.forEach(function(elem) {
                            tbody.appendChild(createTR(elem));
                        });
                    }
                    $( "#tableBody" ).replaceWith(tbody);
                 }
             });
      });
});

function createTR(elem) {
    var tr = document.createElement('tr');
    var idTd = document.createElement('td');
    idTd.appendChild(document.createTextNode(elem.id));
    tr.appendChild(idTd);
        var nameTd = document.createElement('td');
    nameTd.appendChild(document.createTextNode(elem.name));
    tr.appendChild(nameTd);
    var surnameTd = document.createElement('td');
    surnameTd.appendChild(document.createTextNode(elem.surname));
    tr.appendChild(surnameTd);
    var dobTd = document.createElement('td');
    dobTd.appendChild(document.createTextNode(new Date(elem.dob)));
    tr.appendChild(dobTd);
    var telephoneNumberTd = document.createElement('td');
    telephoneNumberTd.appendChild(document.createTextNode(elem.telephoneNumber));
    tr.appendChild(telephoneNumberTd);
    return tr;
}

</script>
<t:wrapper>
    <div class="col-lg-8 col-lg-offset-2 filter-form">
        <form class="form-horizontal">
        <fieldset>
        <h3>Filter</h5>

        <!-- Multiple Radios (inline) -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="radios">Criterion</label>
          <div class="col-md-4">
            <label class="radio-inline" for="radios-0">
              <input type="radio" name="radios" id="radios-0" value="id" checked="checked">
              Id
            </label>
            <label class="radio-inline" for="radios-1">
              <input type="radio" name="radios" id="radios-1" value="tel">
              Telephone
            </label>
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="textinput">Value</label>
          <div class="col-md-4">
          <input id="textinput" name="textinput" type="text" placeholder="Input value" class="form-control input-md" required="" >
          </div>
        </div>

        </fieldset>
        </form>
    </div>
    <div class="col-lg-8 col-lg-offset-2">
        <table id="boards" class="table">
            <h3>EMPLOYEES</h3>
            <thead align="center">
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>DOB</th>
                    <th>TEL.NO.</th>
                </tr>
            </thead>
            <tbody id="tableBody">
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>
					        ${employee.id}
                        </td>
                        <td>
                            ${employee.name}
                        </td>
                        <td>
                            ${employee.surname}
                        </td>
                        <td>
                             ${employee.dob}
                        </td>
                        <td>
                            ${employee.telephoneNumber}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
     </div>
</t:wrapper>