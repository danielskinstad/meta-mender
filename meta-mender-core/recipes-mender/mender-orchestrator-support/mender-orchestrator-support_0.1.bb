require mender-orchestrator-support.inc

################################################################################
#-------------------------------------------------------------------------------
# THINGS TO CONSIDER FOR EACH RELEASE:
# - SRC_URI (particularly "branch")
# - SRCREV
# - DEFAULT_PREFERENCE
#-------------------------------------------------------------------------------

#SRC_URI = "git://github.com/mendersoftware/mender-orchestrator-support;protocol=https;branch=feature/MEN-8416-orchestrator"
SRC_URI = "git://github.com/danielskinstad/mender-orchestrator-support;protocol=https;branch=yocto-recipe"

# We don't actually have a tag 0.1, so point it to the latest revision of feature/MEN-8416-orchestrator
#SRCREV = "120afdbb56aecc48dbeb29dcbf2947ecd34cfb33"
SRCREV = "0ad2049ef7aaf0a6302bf5a10e9c5857dbe7c915"

# Enable this in Betas, and in branches that cannot carry this major version as
# default.
# Downprioritize this recipe in version selections.
#DEFAULT_PREFERENCE = "-1"

################################################################################

# DO NOT change the checksum here without make sure that ALL licenses (including
# dependencies) are included in the LICENSE variable below.
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
"
LICENSE = "Apache-2.0"
