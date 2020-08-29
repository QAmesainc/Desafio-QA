*** Settings ***
Library         Selenium2Library
Suite Setup     Go to homepage
Suite Teardown  Close All Browsers
 
*** Variables ***
${HOMEPAGE}      https://en.wiktionary.org/
${BROWSER}        chrome
 
*** Test Cases ***
Go to wiktionary and search apple
    Input Text      name=search     apple
    Click Element    name=go
    Execute JavaScript    window.scrollTo(0, 300)
    Sleep   2s
    Page Should Contain     A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.     
 
*** Keywords ***
 
Go to homepage
    Open Browser    ${HOMEPAGE}     ${BROWSER}
    Maximize Browser Window
    