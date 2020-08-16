$('document').ready(function(){
    $('table #editButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

       //countries/findById/?id=1
    //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
       $.get(href,function(state,status){
           //country is data, status is status of request
           $('#idEdit').val(state.id);
           $('#ddLCountryEdit').val(state.countryid);
           $('#codeEdit').val(state.code);
           $('#nameEdit').val(state.name);
           $('#capitalEdit').val(state.capital);
           $('#detailsEdit').val(state.details);

       });
        $('#editModal').modal();
    });

    $(' .table #detailsButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

        //countries/findById/?id=1
        //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
        $.get(href,function(state,status){
            //country is data, status is status of request
            $('#idDetails').val(state.id);
            $('#ddLCountryDetails').val(state.countryid);
            $('#nameDetails').val(state.name);
            $('#detailsDetails').val(state.details);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
          //  $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));

        });
        $('#detailsModal').modal();
    });



    //select table
    $('table #deleteButton').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href'); //url of particular record
        $('#delRef').attr('href',href);
        $('#deleteModal').modal();

    });



        });