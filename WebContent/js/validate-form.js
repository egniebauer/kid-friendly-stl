$(document).ready(function () {

$('#kidFriendlyListing').validate({
    rules: {
    	businessName: {
            required: true,
    		maxlength: 45
        },
        businessAddress: {
            required: true,
    		maxlength: 45
        },
        businessCity: {
            required: true,
    		maxlength: 45
        },
        businessState: {
            required: true,
        },
        businessZip: {
        	zipcodeUS: true,
    		maxlength: 5
        },
        businessPhone: {
        	phoneUS: true,
        },
        businessWebsite: {
        	url: true,
    		maxlength: 2083
        },
        category: {
            required: true,
            minlength: 1
        },
        ageRange: {
            required: true,
            minlength: 1
        },
        bestTimes: {
            required: true,
            minlength: 1
        },
        kidsFreeDiscountDetail: {
    		maxlength: 255
        }
    },
    messages: {
    	businessName: {
            required: "The name field is required.",
    		maxlength: "The name field can't exceed 45 characters."
        },
        businessAddress: {
            required: "The address field is required.",
    		maxlength: "The address field can't exceed 45 characters."
        },
        businessCity: {
            required: "The city field is required.",
    		maxlength: "The city field can't exceed 45 characters."
        },
        businessState: {
            required: "The state field is required.",
        },
        businessZip: {
    		maxlength: "The zip must be 5 digits."
        },
        businessWebsite: {
        	url: "Please enter a valid url (remember: http://).",
        	maxlength: "Please enter a shorter website address."
        },
        category: {
            required: "Please select at least one category.",
            minlength: "Please select at least one category."
        },
        ageRange: {
            required: "Please select at least one age group.",
            minlength: "Please select at least one age group."
        },
        bestTimes: {
            required: "Please select at least one time of day.",
            minlength: "Please select at least one time of day."
        },
        kidsFreeDiscountDetail: {
    		maxlength: "The detail section can't exceed 255 characters."
        }
    },
	errorElement: "em",
	errorPlacement: function ( error, element ) {
		// Add the `help-block` class to the error element
		error.addClass( "help-block" );

		if ( element.prop( "type" ) === "checkbox" ) {
			error.insertBefore( element.parent( "label" ) );
		} else {
			error.insertAfter( element );
		}
	},
	highlight: function ( element, errorClass, validClass ) {
		$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
	},
	unhighlight: function (element, errorClass, validClass) {
		$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
	}
});
});
