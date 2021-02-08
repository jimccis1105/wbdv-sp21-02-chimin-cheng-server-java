var users = [
    {username: "dora77", password: "1234", firstname: "Dora", lastname: "Explorer", role:"FACULTY"},
    {username: "jim80", password: "4321", firstname: "Jim", lastname: "Butler", role:"STUDENT"},
    {username: "admin10", password: "2468", firstname: "Admin", lastname: "Lopez", role:"ADMIN"},
];

var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn, $updateBtn;
var $tbody;

function createUser() {
    var newUser = {
        username: $usernameFld.val(),
        password: $passwordFld.val(),
        firstname: $firstNameFld.val(),
        lastname: $lastNameFld.val(),
        role: $roleFld.val(),
    }
    users.push(newUser);
    $usernameFld.val("");
    $passwordFld.val("");
    $firstNameFld.val("");
    $lastNameFld.val("");
    $roleFld.val("");
    renderUsers(users);
}

function deleteUser(event) {
    var button = $(event.target);
    var index = button.attr("id");
    users.splice(index, 1);
    renderUsers(users);
}

var selectedUser = null;
var user_id = null;
function selectUser(event) {
    var id = $(event.target).attr("id");
    selectedUser = users[id];
    $usernameFld.val(selectedUser.username);
    $passwordFld.val(selectedUser.password);
    $firstNameFld.val(selectedUser.firstname);
    $lastNameFld.val(selectedUser.lastname);
    $roleFld.val(selectedUser.role);
    user_id = id;
}

function updateUser() {
    selectedUser.username = $usernameFld.val();
    selectedUser.password = $passwordFld.val();
    selectedUser.firstname = $firstNameFld.val();
    selectedUser.lastname = $lastNameFld.val();
    selectedUser.role = $roleFld.val();
    users[user_id] = selectedUser;
    $usernameFld.val("");
    $passwordFld.val("");
    $firstNameFld.val("");
    $lastNameFld.val("");
    $roleFld.val("");
    selectedUser = null;
    renderUsers(users);
}

function renderUsers(users) {
    $tbody.empty();
    for(var i=0; i<users.length; i++) {
        var user = users[i];
        $tbody
            .prepend(`
      <tr>
          <td>${user.username}</td>
          <td>${user.firstname}</td>
          <td>${user.lastname}</td>
          <td>${user.role}</td>
          <td>
              <i id="${i}" class="fa-2x fa fa-times wbdv-remove"></i>
              <i id="${i}" class="fa-2x fa fa-pencil wbdv-edit"></i>
          </td>
      </tr>
      `)
    }
    $removeBtn = $(".wbdv-remove");
    $removeBtn.click(deleteUser);
    $editBtn = $(".wbdv-edit");
    $editBtn.click(selectUser);
}

function main() {
    $tbody = jQuery(".wbdv-tbody");
    renderUsers(users);

    $createBtn = $(".wbdv-create");
    $updateBtn = $(".wbdv-update");

    $usernameFld = $("#usernameFld");
    $passwordFld = $("#passwordFld");
    $firstNameFld = $("#firstNameFld");
    $lastNameFld = $("#lastNameFld");
    $roleFld = $("#roleFld");

    $createBtn.click(createUser);
    $updateBtn.click(updateUser);
}
$(main);
