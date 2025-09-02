inherit mender-licensing

inherit systemd

SUB_FOLDER:arm = "arm"
SUB_FOLDER:aarch64 = "aarch64"
SUB_FOLDER:x86-64 = "x86_64"

COMPATIBLE_HOSTS = "arm|aarch64|x86_64"

FILES:${PN} = " \
    ${bindir}/mender-orchestrator \
"

FILES:${PN} = " \
    ${datadir}/mender-orchestrator/manifests/topology.yaml \
"

FILES:${PN}:append:mender-update-install = " \
    ${datadir}/mender/inventory/mender-inventory-mender-orchestrator \
"

S = "${WORKDIR}/mender-orchestrator-${PV}"

do_version_check() {
    if [ ! -e ${S}/${SUB_FOLDER}/mender-orchestrator ]; then
        bbfatal "No mender-orchestrator binary found. Have you added the package to SRC_URI?"
    fi

    if [ ! -e ${S}/${SUB_FOLDER}/topology.yaml ]; then
        bbfatal "No topology.yaml found. Have you added the package to SRC_URI?"
    fi

    if ! ${@'true' if d.getVar('MENDER_DEVMODE') else 'false'}; then
        if ! strings ${S}/${SUB_FOLDER}/mender-orchestrator | grep -q "^${PV}$"; then
            bbfatal "String '${PV}' not found in binary. Is it the correct version? Check with --version."
        fi
    fi
}
addtask do_version_check after do_unpack before do_install

do_install() {
    install -d -m 755 ${D}${bindir}
    install -m 755 ${S}/${SUB_FOLDER}/mender-orchestrator ${D}${bindir}/mender-orchestrator
    install -m 755 ${S}/${SUB_FOLDER}/topology.yaml ${D}${datadir}/mender-orchestrator/manifests/topology.yaml
}

do_install:append:mender-update-install() {
    install -d -m 755 ${D}${datadir}/mender/inventory/
    install -m 775 ${S}/support/mender-inventory-orchestrator-inventory ${D}${datadir}/mender/inventory/mender-inventory-orchestrator-inventory
}
