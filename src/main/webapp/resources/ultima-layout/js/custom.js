$(document).on('keyup', '.numeric-only', function (event) {
    var v = this.value;
    if ($.isNumeric(v) === false) {
        //chop off the last char entered
        this.value = this.value.slice(0, -1);
    }

    if (event.which === 32) {
        //chop off the last char entered
        this.value = this.value.slice(0, -1);
    }
});


$(document).on('keyup', '.double-only', function (event) {
    var v = this.value;

    var m = v.match(/^\d{0,9}(?:\.\d{0,2}){0,1}$/);

    if (!m) {
        this.value = this.value.slice(0, -1);
    }

});