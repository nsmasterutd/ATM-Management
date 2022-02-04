<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<script type="text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>


</head>
<body>

<nav class="navbar navbar-expand-lg  text-white bg-primary ">
  <a class="navbar-brand text-white" href="#">ATM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     
    </ul>Welcome :
   <c:out value="${userAccount}"/> 
<form action="AtmServlet" method="post" class="form-inline my-2 my-lg-0 bg-success">
<input type="hidden" name="why" value="BALANCE_INQUIRY"/>
<input type="submit" value="BalanceInquiry" class="btn btn-primary" />
</form> <form action="AtmServlet" method="post" class="form-inline my-2 my-lg-0 bg-success">
<input type="hidden" name="why" value="Logout"/>
<input type="submit" value="Logout" class="btn btn-primary"/>
</form>
    
  </div>
</nav>
<h1>
</h1>



<br/><br/>
<div class="row">
  <div class="col-4">
    <div class="list-group" id="list-tab" role="tablist">
     
      <a class="list-group-item list-group-item-action" id="list-MiniStatement-list" data-toggle="list" href="#list-MiniStatement" role="tab" aria-controls="MiniStatement"><form action="AtmServlet" method="get">
<input type="hidden" name="why" value="MINI_STATEMENT"/>
<input type="submit" value="MINI_STATEMENT" class="btn btn-primary"/>
</form></a>
      <a class="list-group-item list-group-item-action" id="list-Withdrawal-list" data-toggle="list" href="#list-Withdrawal" role="tab" aria-controls="Withdrawal"><form action="AtmServlet" method="get">
<input type="hidden" name="why" value="Deposit"/>
<input type="submit" value="WITHDRAWAL" class="btn btn-primary" />
</form></a>
      <a class="list-group-item list-group-item-action" id="list-Deposit-list" data-toggle="list" href="#list-Deposit" role="tab" aria-controls="Deposit"><form action="AtmServlet" method="get">
<input type="hidden" name="why" value="Withdrawal"/>
<input type="submit" value="Deposit" class="btn btn-primary"/>
</form></a>
     <a class="list-group-item list-group-item-action" id="list-ChangePin-list" data-toggle="list" href="#list-ChangePin" role="tab" aria-controls="ChangePin"><form action="AtmServlet" method="get">
<input type="hidden" name="why" value="CHANGE_PIN"/>
<input type="submit" value="CHANGE_PIN" class="btn btn-primary" />
</form></a>
    
    </div>
  </div>
  <div class="col-8">
    <div class="tab-content" id="nav-tabContent">
       <div class="tab-pane fade" id="list-MiniStatement" role="tabpanel" aria-labelledby="list-MiniStatement-list"><form action="AtmServlet" method="post">
<input type="date" name="sdate" placeholder="Enter starting Date"/>
<input type="date" name="edate" placeholder="Enter Ending Date"/>
<input type="hidden" name="why" value="MINI_STATEMENT"/>
<input type="submit" value="Print_MINI_STATEMENT" class="btn btn-primary"/>
</form></div>
      <div class="tab-pane fade" id="list-Withdrawal" role="tabpanel" aria-labelledby="list-Withdrawal-list"><form action="AtmServlet" method="post">
<input type="number" name="amount" placeholder="Enter Amount"/>

<input type="hidden" name="why" value="Withdrawal"/>
<input type="submit" class="btn btn-primary" />
</form></div>
      <div class="tab-pane fade" id="list-Deposit" role="tabpanel" aria-labelledby="list-Deposit-list"><form action="AtmServlet" method="post">
<input type="number" name="amount" placeholder="Enter Amount"/>

<input type="hidden" name="why" value="Deposit"/>
<input type="submit" class="btn btn-primary" />
</form></div>
    <div class="tab-pane fade" id="list-ChangePin" role="tabpanel" aria-labelledby="list-ChangePin-list"><form action="AtmServlet" method="post">
<input type="number" name="pin" placeholder="Enter New Pin"/>

<input type="hidden" name="why" value="CHANGE_PIN"/>
<input type="submit" class="btn btn-primary" />
</form></div>
   
    </div>
  </div>
</div>

<br>
<div class="card text-center">
  <div class="card-header bg-primary text-white">
   Notice
  </div>
  <div class="card-body">
    <h5 class="card-title"> <c:out value="${balance}"/> </h5>
    <h5 class="card-title">  <c:out value="${messageaccount}"/> </h5>
   <h5 class="card-title">  <c:out value="${balancestatus}"/> </h5>
   <h5 class="card-title">  <c:out value="${pin}"/> </h5> 
    <p class="card-text">
   
    <table class="table">
  <thead class=" bg-primary text-white">
    <tr>
     
      <th scope="col">Amount</th>
      <th scope="col">Type</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody><c:forEach var ="x" items ="${tlist}">
    <tr>
     
      <td><c:out value="${x.getAmount()}"/></td>
      <td><c:out value="${x.getType()}"/></td>
      <td><c:out value="${x.getTdate()}"/></td>
    </tr></c:forEach>
  </tbody>
</table>

    
    
    
    
<Br/> 
</p>
   
  </div>
  <div class="card-footer text-muted">
   
  </div>
</div>

</body>
</html> 