<%@include file="/WEB-INF/views/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="am-g am-g-fixed login">
	<div class="am-u-md-8 am-u-md-offset-2">
		<form action="updateNewPass.do"
			class="am-form" id="doc-vld-msg" method="post">
			<fieldset>
				<legend>修改密码</legend>
				<c:if test="${not empty loginErr }">
			<div class="am-alert am-alert-danger" data-am-alert>
			 <button type="button" class="am-close">&times;</button>
  					${loginErr }
			</div>
		</c:if>

				<div class="am-form-group">
					<label for="doc-vld-pw">请输入密码：</label> <input type="password"
						id="doc-vld-pw" placeholder="请输入密码" required
						data-validation-message="请输入密码！" name="newPassword" />
				</div>

				<div class="am-form-group">
					<label for="doc-vld-pw-2">确认密码：</label> <input type="password"
						id="doc-vld-pw-2" placeholder="请与上面输入的值一致"
						data-equal-to="#doc-vld-pw" required
						data-validation-message="与上面的密码不一致！" />
				</div>

				<div class="am-g am-g-fixed login-center">
					<button class="am-btn am-btn-secondary am-round" type="submit"
						data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400, height: 225}">确定</button>
				</div>
			</fieldset>
		</form>
		
	</div>
</div>


<script type="text/javascript">
	$(function() {
		$('#doc-vld-msg')
				.validator(
						{
							onValid : function(validity) {
								$(validity.field).closest('.am-form-group')
										.find('.am-alert').hide();
							},

							onInValid : function(validity) {
								var $field = $(validity.field);
								var $group = $field.closest('.am-form-group');
								var $alert = $group.find('.am-alert');
								// 使用自定义的提示信息 或 插件内置的提示信息
								var msg = $field.data('validationMessage')
										|| this.getValidationMessage(validity);

								if (!$alert.length) {
									$alert = $(
											'<div class="am-alert am-alert-danger"></div>')
											.hide().appendTo($group);
								}

								$alert.html(msg).show();
							}
						});
	});
</script>
    
    
    
<%@include file="/WEB-INF/views/footer.jsp"%>