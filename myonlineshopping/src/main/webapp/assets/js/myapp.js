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
		
	default:
		$('#listProduct').addClass('active');
	   $('#a_'+menu).addClass('active');
	break;
		
	
	}
	
	//code for jquery datatable
	//create a data set
	var products=[
		['1','abc'],
		['2','cde'],
		['3','efg'],
		['4','ghi'],
		['5','jkl'],
		['6','mno'],
		['7','pqr'],
		['8','stu'],
		['9','vwx']
	];
	var $table=$('#productListTable')
	//execute the bleo code only where we have the table
	if($table.length){
		console.log('inside the table !!!');
	}
});