/**
 * Global
 */
function Global (arg){
	this.context = arg;
};
Global.prototype.setContext = function(context) {
	this.context = context;
}
Global.prototype.getContext = function() {
	return this.context;
}
Global.prototype.createArticle = function(){
	return new Article();
}





