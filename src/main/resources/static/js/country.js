$('document').ready(function(){
    $('table #editButton').on('click',function (event){
        event.preventDefault(); // dont show data in JSON format, but in modal.

       //countries/findById/?id=1
    //href is equal by line 5
        var href=$(this).attr('href'); // this refers to the button
       $.get(href,function(country,status){
           //country is data, status is status of request
           $('#idEdit').val(country.id);
           $('#descriptionEdit').val(country.description);
           $('#capitalEdit').val(country.capital);
           $('#codeEdit').val(country.code);
           $('#continentEdit').val(country.continent);
           $('#nationalityEdit').val(country.nationality);
       });
        $('#editModal').modal();
    });
    //select table
    $('table #deleteButton').on('click',function(event){
       event.preventDefault();

       var href = $(this).attr('href'); //url of particular record
        $('#confirmDeleteButton').attr('href',href);
       $('#deleteModal').modal();

    });



        });