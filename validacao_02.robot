*** Settings ***
Library         Selenium2Library
Suite Setup     Go to homepage
Suite Teardown  Close All Browsers
 
*** Variables ***
${HOMEPAGE}      https://en.wiktionary.org/
${BROWSER}        chrome
 
*** Test Cases ***
Go to wiktionary and search pear
    Input Text      name=search     pear
    Click Element    name=go
    Execute JavaScript    window.scrollTo(0, 300)
    Sleep   2s
    Page Should Contain     An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.   
 
*** Keywords ***
 
Go to homepage
    Open Browser    ${HOMEPAGE}     ${BROWSER}
    Maximize Browser Window