<!DOCTYPE html>


<html>

  <head>
    <meta charset="UTF-8">
    
<title> Popcorn-Results </title>
  
</head>

  <body>
    <?php

	if(isset($_POST['name'])){ 
	// Get form data values

		  $unpop = $_POST["unpop"];
		  $caramel = $_POST["caramel"];
		  $caramelnut = $_POST["caramelnut"];
		  $toffeynut = $_POST["toffeynut"];
		  $name = $_POST["name"];
		  $street = $_POST["street"];
		  $city = $_POST["city"];
		  $payment = $_POST["payment"];

	// If any of the quantities are blank, set them to zero

		  if ($unpop == "") $unpop = 0;
		  if ($caramel == "") $caramel = 0;
		  if ($caramelnut == "") $caramelnut = 0;
		  if ($toffeynut == "") $toffeynut = 0;

	// Compute the item costs and total cost

		  $unpop_cost = 3.0 * $unpop;
		  $caramel_cost = 3.5 * $caramel;
		  $caramelnut_cost = 4.5 * $caramelnut;
		  $toffeynut_cost = 5.0 * $toffeynut;
		  $total_price = $unpop_cost + $caramel_cost + 
						 $caramelnut_cost + $toffeynut_cost;
		  $total_items = $unpop + $caramel + $caramelnut + $toffeynut;

	// Return the results to the browser in a table

		?>
		<h4> Customer: </h4>
		<?php
		  print ("$name <br /> $street <br /> $city <br />");
		?>
		<p /> <p />

		<table border = "1">
		  <caption> Order Information </caption>
		  <tr>
			<th> Product </th>
			<th> Unit Price </th>
			<th> Quantity Ordered </th>
			<th> Item Cost </th>
		  </tr>
		  <tr align = "center">
			<td> Unpopped Popcorn </td>
			<td> $3.00 </td>
			<td> <?php print ("$unpop"); ?> </td>
			<td> <?php printf ("$ %4.2f", $unpop_cost); ?>
			</td>
		  </tr>
		  <tr align = "center">
			<td> Caramel Popcorn </td>
			<td> $3.50 </td>
			<td> <?php print ("$caramel"); ?> </td>
			<td> <?php printf ("$ %4.2f", $caramel_cost); ?>
			</td>
			</tr>
		  <tr align = "center">
			<td> Caramel Nut Popcorn </td>
			<td> $4.50 </td>
			<td> <?php print ("$caramelnut"); ?> </td>
			<td> <?php printf ("$ %4.2f", $caramelnut_cost); ?>
			</td>
		  </tr>
		  <tr align = "center">
			<td> Toffey Nut Popcorn </td>
			<td> $5.00 </td>
			<td> <?php print ("$toffeynut"); ?> </td>
			<td> <?php printf ("$ %4.2f", $toffeynut_cost); ?>
			</td>
		  </tr>
		</table>
		<p /> <p />

		<?php
		  echo ("You ordered $total_items popcorn items <br />");
		  printf ("Your total bill is: $ %5.2f <br />", $total_price);
		  echo ("Your chosen method of payment is: $payment <br />");
		
		}else{ ?>
				<h2> Welcome to Computer Science Club Popcorn  Sales </h2>
				 <form action = "popcorn1.php" method = "post">

	
				
	  

      <table>


			  <!-- Form fields for the customer's name and address -->
			  

	<tr>

					<td> Buyer's Name: </td>
			  
	  <td> <input type = "text"  name = "name" size = "30" /> </td>
			  
	</tr>
			  
	<tr>

					<td> Street Address: </td>
			  
	  <td> <input type = "text"  name = "street" size = "30" /></td>
			  
	</tr>
			  
	<tr>

						<td> City, State, Zip: </td>
			  
	  <td> <input type = "text"  name = "city" size = "30" /></td>

				  </tr>

			</table>

	  
			<br />


	  
			<table border = "0">



		  <!-- First, the column headings -->


			  <tr>

				<th> Product </th>

				<th> Price </th>
		  
	  <th> Quantity </th>
		  
	</tr>



			  <!-- Now, the table data entries -->


				  <tr>

					<td> Unpopped Popcorn (1 lb.) </td>

					<td> $3.00 </td>
			  
       <td align="center"> <input type = "number" min="0" max="10"   name = "unpop" size = "3" /></td>
			  
	</tr>
			  
	<tr>
			  
	  <td> Caramel Popcorn (2 lb. canister) </td>

					<td> $3.50 </td>

					<td align="center"><input type = "number" min="0" max="10" name = "caramel"
 size = "3" /></td>
				  </tr>

				  <tr>
			  
	  <td> Caramel Nut Popcorn (2 lb. canister) </td>
			  
	  <td> $4.50 </td>
			  
	  <td align="center"><input type = "number" min="0" max="10"  name = "caramelnut"
 size = "3" /></td>
			  
	</tr>
			  
	<tr>

						<td> Toffey Nut Popcorn (2 lb. canister) </td>
			  
          <td> $5.00 </td>
			  
          <td align = "center"><input type = "number" min="0" max="10"  name = "toffeynut"
 size = "3" /> </td>

				  </tr>
	  
      </table>

	  
      <br />



			<!-- The radio buttons for the payment method -->
	  

      <h3> Payment Method </h3>

			<p>

			  <input type = "radio"  name = "payment"  value = "visa" 
checked = "checked" /> 
	  
		Visa <br />

			  <input type = "radio"  name = "payment"  value = "mc" />
	   
		Master Card <br />

			  <input type = "radio"  name = "payment"  value = "discover" />

			  Discover <br />

			  <input type = "radio"  name = "payment"  value = "check" /> 
	  
		Check <br /> <br />



			   <!-- The submit and reset buttons -->
	  

        <input type = "submit"  value = "Submit Order" />

			  <input type = "reset"  value = "Clear Order Form" />
	  
      </p>

		  </form>
			
		<?php 
		}
		?>
		
  </body>
</html>

