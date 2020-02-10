$(function () {
	//solve the active menu bar 
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
		
/*	default:
		$('#listProduct').addClass('active');
	   $('#a_'+menu).addClass('active');
	break;*/
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;	
	
	}
	
	//code for jquery datatable
	//create a data set
/*	var products=[
		['1','abc'],
		['2','cde'],
		['3','efg'],
		['4','ghi'],
		['5','jkl'],
		['6','mno'],
		['7','pqr'],
		['8','stu'],
		['9','vwx']
	];*/
	var $table=$('#productListTable')
	//execute the bleo code only where we have the table
	if($table.length){
		console.log('inside the table !!!');
		console.log('inside the table !!!');
		
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		}
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Recd','5 Recd','10 Recd','ALL']],
			pageLength : 5,
			/*data:products*/
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';

					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
				},
				{
					data : 'quantity'
						
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {
						var str = '';
						str += '<a href="'+ window.contextRoot+ '/show/'+ data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						return str;
					}

				}
			]
		});
	}
});