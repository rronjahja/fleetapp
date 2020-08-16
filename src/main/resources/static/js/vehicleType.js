$('document').ready(function(){
    $('table #editButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

        //countries/findById/?id=1
        //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
        $.get(href,function(vehicleType,status){
            //country is data, status is status of request
            $('#idEdit').val(vehicleType.id);
            $('#descriptionEdit').val(vehicleType.name);
            $('#detailsEdit').val(vehicleType.details);

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
            $('#descriptionDetails').val(state.countryid);
            $('#detailsDetails').val(state.details);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
            $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));

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