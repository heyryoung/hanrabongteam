"use strict";
var auth = auth || {}

auth = (()=>{
	let _,js,auth_vuejs;
	let init = ()=>{
		_=$.ctx();
		js=$.js();
		auth_vuejs = js+'/vue/auth_vue.js';
	} 
	let onCreate =()=>{
		init();
		$.getScript(auth_vuejs).done(()=>{
        	setContentView()
    		$('#a_go_join').click(e=>{
         		e.preventDefault()
         		join()
    		})
        }).fail(()=>{alert(WHEN_ERR)})
	}
	
	let setContentView = ()=>{
		login()
	}
	
	let join = ()=>{
		alert('회원가입 클릭!!')
				$.getScript(auth_vuejs)
					$('head').html(auth_vue.join_head())
					$('body').html(auth_vue.join_body()).addClass('text-center')
					$('<button>',{
							text : 'Continue to checkout' , 
							href: '#' ,
							click : e=>{
								e.preventDefault();
								let data = { cid :  $('#cid').val() ,
										cpw : $('#cpw').val()
								}
								$.ajax({
									url : _+'/hcust/join', 
									type : 'POST',
									dataType : 'json',
									data: JSON.stringify(data) , 
									contentType : 'application/json',
									success : d =>{
										alert('AJAX 성공  cid : ' +d.cid+',  cpw: ' + d.cpw)
										e.preventDefault()
										login()
									},
									error : e =>{
										alert('AJAX실패' + url)
									}
								})    
							} 
						})
						.addClass('btn btn-primary btn-lg btn-block')
						.appendTo('#btn_join')
	}	
	
	let login = ()=>{
		let x = {css : $.css(), img : $.img(), js:$.js() }
		$('head').html(auth_vue.login_head(x))		
		$('body')
		.addClass('text-center')
		.html(auth_vue.login_body(x))
		$('<button>',{
			type: "submit",
			text : "Log In",
			click: 	e=>{									
					e.preventDefault()
					
			}
		})
		.addClass('btn btn-lg btn-primary btn-block')
		.appendTo('#btn_login')		
	}
	
	return {onCreate, join, login}
})();