$('document').ready(function(){
    $('table #editButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

        //countries/findById/?id=1
        //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
        $.get(href,function(vehicleModel,status){
            //country is data, status is status of request
            $('#idEdit').val(vehicleModel.id);
            $('#descriptionEdit').val(vehicleModel.description);
            $('#detailsEdit').val(vehicleModel.details);

        });
        $('#editModal').modal();
    });

    $(' .table #detailsButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

        //countries/findById/?id=1
        //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
        $.get(href,function(vehicleModel,status){
            //country is data, status is status of request
            $('#idDetails').val(vehicleModel.id);
            $('#descriptionDetails').val(vehicleModel.description);
            $('#detailsDetails').val(vehicleModel.details);
            $('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleModel.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#createdByDetails').val(vehicleModel.createdBy);
            $('#createdDateDetails').val(vehicleModel.createdDate);

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