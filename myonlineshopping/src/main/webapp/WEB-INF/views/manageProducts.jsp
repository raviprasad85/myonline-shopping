<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
	
	<c:if test="${not empty message}">	
	<div class="col-xs-12">
	<div class="alert alert-success alert-dismissible">
	
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	
	${message}
	</div>
	
	</div>
</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product management</h4>
				</div>

				<div class="panel-body">

					<!-- form element -->

					<sf:form class="form-horizontal" modelAttribute="product"
					 action="${contextRoot}/manage/products"
					  method="POST"
					  enctype="multipart/form-data"
					  >
						<div class="form-group">
							<label class="control-lavel col-md-4" for="name">Enter Product name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product name" class="form-control" /> <!-- <em class="help-block"> Please enter Product name!</em> -->
							    <sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>



						<div class="form-group">
							<label class="control-lavel col-md-4" for="brand">Enter Brand name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand name" class="form-control" /> <!-- <em class="help-block"> Please enter Brand name!</em> -->
							    <sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>



						<div class="form-group">
							<label class="control-lavel col-md-4" for="description">Product
								Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write a Descrioption" class="form-control"/>
					            <sf:errors path="description" cssClass="help-block" element="em"/>

							</div>
						</div>



						<div class="form-group">
							<label class="control-lavel col-md-4" for="unitPrice">Enter
								Unit price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit Prive in &#8360" class="form-control" />
                             <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>
         <!-- file element for image upload -->
						<div class="form-group">
							<label class="control-lavel col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />

							</div>
						</div>
						
						
							<div class="form-group">
							<label class="control-lavel col-md-4" for="file">Select an Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"  class="form-control" />
                                <sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-lavel col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="from-control" id="categoryId" path="categoryId"
								
								items="${categories}"
								itemLabel="name"
								itemValue="id"
								/>
									

							</div>
						</div>


						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn-btn-primary" />
									<!-- hide all filed products -->
                    <sf:hidden path="id"/>
                     <sf:hidden path="code"/>
                      <sf:hidden path="supplierId"/>
                       <sf:hidden path="active"/>
                        <sf:hidden path="purchases"/>
                        <sf:hidden path="views"/>
							</div>
						</div>




					</sf:form>
				</div>
			</div>

		</div>
	</div>
<div class="row">

<div class='col-xs-12'>

<h3>available product</h3>
<hr/>
</div>



<div class='col-xs-12'>

<div style="overflow:auto">
<!-- products admin table -->
<table id="adminDataTableImg" class="table table-striped table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Brand</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>unit price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
	<%-- 			<tbody>
				<tr>
				<td>1 </td>
				<td>
				<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDABC123DEFX.jpg" alt="iPhone 5s">
				
				 </td>
				<td>apple</td>
				<td>iPhone 5s</td>
				<td>3 </td>
				<td>&#8377; 18000.00 /-</td>
				<td> 
				<!-- toggle switch -->
				<label class="switch">
				
				<input type="checkbox" checked="checked" value="1"/>
				<div class="slider"></div>
				</label>
				
				</td>
				<td>
				<a href="${contextRoot}/manage/1/product" class="btn btn-warning">
				<span class="glyphicon glyphicon-pencil"></span>
				</a>
				 </td>
				</tr>
				
				
				
				<tr>
				<td>1 </td>
				<td>
				<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDABC123DEFX.jpg" alt="iPhone 5s">
				
				 </td>
				 <td>apple</td>
				<td>iPhone 5s</td>
				<td>3 </td>
				<td>&#8377; 18000.00 /-</td>
				<td> 
				<!-- toggle switch -->
				<label class="switch">
				
				<input type="checkbox"  value="1"/>
				<div class="slider"></div>
				</label>
				
				</td>
				<td>
				<a href="${contextRoot}/manage/1/product" class="btn btn-warning">
				<span class="glyphicon glyphicon-pencil"></span>
				</a>
				 </td>
				</tr>
				</tbody> --%>
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Brand</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>unit price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
</div>

</div>

</div>

</div>