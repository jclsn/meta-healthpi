FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

inherit populate_sdk_qt5
inherit extrausers

PASSWD = "\$6\$ScXd7DjcBSNELWEN\$TftxAzNnMJg/o2qq4md1eD9jO9G3AncQ6TAOShLzrSy0WCzg0LhRvgBqHhTYp09RZd7S5h5Rwp4CItTHBUwmM0"
EXTRA_USERS_PARAMS = " \
    usermod -p '' root; \
    useradd -p '$PASSWD' pi; \
"

