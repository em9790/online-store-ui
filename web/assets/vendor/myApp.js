$(function () {

    //solving active menu problem
    switch (menu) {
        case "About Us":
            $('#about').addClass('active');
            break;
        case "Contact Us":
            $('#contact').addClass('active');
            break;
        case "All Products":
            $('#listProducts').addClass('active');
            break;
        default:
            if(menu == "Home") break;
            $('#listProducts').addClass('active');
            $('#a_' +menu.replace(' ', '')).addClass('active');
            break;
    }

    var $table = $('#productListTable');
    if($table.length){
        var jsonUrl='';

        if(!window.categoryId)
            jsonUrl = window.contextRoot+'/json/data/all/products';
        else
            jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
        $table.DataTable({
            lengthMenu:[[3,5,10,-1],['3 records','5 records', '10 records', 'All']],
            pageLength:5,
            ajax:{
                url:jsonUrl,
                dataSrc:''
            },
            columns:[
                {
                    data:'code',
                    mRender:function (data,type,row) {
                        return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="product-list-img" />';
                    }
                },
                {
                    data:'name',
                },
                {
                    data:'brand',
                },
                {
                    data:'unitPrice',
                    mRender:function (data,type,row) {
                        return '$ ' + data;
                    }
                },
                {
                    data:'quantity',
                },
                {
                    data:'id',
                    bSortable:false,
                    mRender:function (data,type,row) {
                        let str ='';
                        str += '<a href="'+window.contextRoot+'/show'+data+'/product" class="btn btn-primary"><i class="fa fa-eye"></i></a> &#160;'
                        str += '<a href="'+window.contextRoot+'/card/add'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart"></i></a>'
                        return str;
                    }
                }
            ],
        });
    }
})