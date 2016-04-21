/**
 * Global
 */
function Global (arg1,arg2,arg3){
	this.context = arg1;
	this.name = arg2;
	this.age = arg2;
};
Global.prototype.setContext = function(context) {
	this.context = context;
}
Global.prototype.getContext = function() {
	return this.context;
}