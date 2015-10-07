<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
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

var propertyNames = ['id','name','surname','telephoneNumber'];

function createTR(elem) {
    var tr = document.createElement('tr');
    propertyNames.forEach(function(propertName){
         var td = document.createElement('td');
         td.appendChild(document.createTextNode(elem[propertName]));
         tr.appendChild(td);
    });
    var dobTd = document.createElement('td');
    dobTd.appendChild(document.createTextNode(new Date(elem.dob)));
    tr.appendChild(dobTd);
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
                    <th>TEL.NO.</th>
                    <th>DOB</th>
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
                            ${employee.telephoneNumber}
                        </td>
                        <td>
                             ${employee.dob}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
     </div>
</t:wrapper>