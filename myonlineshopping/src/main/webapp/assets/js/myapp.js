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
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
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
			jsonUrl = window.contextRoot + '/json/data/catgory/'+ window.categoryId + '/products';
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
					data : 'quantity',
						mRender : function(data,type,row){
							if(data<1){
								return '<span style="color:red"> Out Of Stock</span>';
							} 
							return data;
						}
						
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {
						var str = '';
						str += '<a href="'+ window.contextRoot+ '/show/'+ data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if(row.quantity <1){
							str += '<a href="javascripts:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							
						} else{
							str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						
						/*str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';*/
						return str;
					}

				}
			]
		});
	}
	
	//dismissing the alert after 3 sec
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
			
		},3000)
	}
	
	//---
	$('.switch input[type="checkbox"]').on('change',function(){
		var checkbox = $(this);
		var checked=checkbox.prop('checked');
		var dMsg = ('checked')? 'You Want to activate the product ?':
		                       'You Want to activate the product ?';
		var value=checkbox.prop('value');
		bootbox.confirm({
			size: 'medium',
			title:'Product Activation & Deativation',
			message: dMsg,
			callback: function(confirmed){
				
				if(confirmed){
					console.log(value);
					console.log(value);
					console.log(message);
					bootbox.alert({
						size:'medium',
						title:'Information',
						message:'You are going to perform operation on product'+value
					});
				}else{
					checkbox.prop('checked',!checked); 
				}
			}
			
		
			
			
		});
		
	});
	
	//-----------------------------------------------
	//data table admin
	//-----------------------------------------------
	
	var $adminProductstable=$('#adminDataTableImg')
	//execute the bleo code only where we have the table
	if($adminProductstable.length){
		console.log('inside the table !!!');
		console.log('inside the table !!!');
		
		var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
	
		
		$adminProductstable.DataTable({
			lengthMenu:[[10,30,50,-1],['10 Recd','30 Recd','50 Recd','ALL']],
			pageLength : 30,
			/*data:products*/
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{data:'id'},
				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="adminDataTableImg"/>';

					}
				},
				{
					data : 'brand'
				},
				{
					data : 'name'
				},
				
				
				{
					data : 'quantity',
						mRender : function(data,type,row){
							if(data<1){
								return '<span style="color:red"> Out Of Stock</span>';
							} 
							return data;
						}
						
				},
				
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
				},
				{
					data : 'active',
					bSortable:false,
					mRender:function(data,type,row){
						var str='';
						str+= '<label class="switch">';
						if(data){
							
							str+= '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
						}
						else{
							str+= '<input type="checkbox" value="'+row.id+'"/>';
						}
						
						str+= '<div class="slider"></div></label>';
						
						return str;
					}
						
						/*str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';*/
				
				

				},
				{
					data:'id',
					bSortable:false,
					mRender:function(data,type,row){
						var str='';
						str+='<a href="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">';
						str+='<span class="glyphicon glyphicon-pencil"></span></a>';
						return str;
							
					}
				}
				
			],
			initComplete: function () {
				var api=this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox = $(this);
					var checked=checkbox.prop('checked');
					var dMsg = ('checked')? 'You Want to activate the product ?':
					                       'You Want to activate the product ?';
					var value=checkbox.prop('value');
					bootbox.confirm({
						size: 'medium',
						title:'Product Activation & Deativation',
						message: dMsg,
						callback: function(confirmed){
							
							if(confirmed){
								console.log(value);
								console.log(value);
								//activation url
								var activationUrl=window.contextRoot + '/manage/product/'+value+'/activation';
								$.post(activationUrl,function(data){
									bootbox.alert({
										size:'medium',
										title:'Information',
										message: data
									});
									
								})
								
							}else{
								checkbox.prop('checked',!checked); 
							}
						}
						
					
						
						
					});
					
				});
				
			}
		});
	}
	
	//-----------------------------------------------
	//End data table admin
	//-----------------------------------------------
	
	
});