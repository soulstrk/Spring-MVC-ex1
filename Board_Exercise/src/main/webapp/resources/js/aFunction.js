/**
 * 
 */
$(document).ready(function() {
	
	$('#btn1').click(function() {
		location.href = "boardInsert";
	});
});

function runCheck() {
	$('input[name=title]').prop('checked',title);
	$('input[name=writer]').prop('checked',writer);
	$('input[name=content]').prop('checked',content);		
}
	
	
