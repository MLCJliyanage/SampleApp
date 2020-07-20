var JSPlugin = new function() {

    this.gotoMain= function(msg) {
            var msg = document.getElementById("myInput").value;
             AndroidJs.gotoMain(msg);
       };

       this.showName=function(msg) {
            var msg = document.getElementById("myInput").value;
             AndroidJs.showName(msg);
       };
};
