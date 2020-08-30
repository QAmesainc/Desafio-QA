

describe('TC01_Search_Main_Page', function(){

    beforeEach(() => {
      //  cy.exec('npm run db:reset && npm run db:seed')

      })

    /**Check if it the right site */
    it('has a title', function () {
        cy
            .visit('/') 
            .contains('Wiktionary, the free dictionary')
            
    }),
    /**Validation 1 */
    it('search_apple', function () {
        cy
            .visit('/') 
            .get('.bodySearchWrap').type('apple')
            .get('input[type="submit"]').contains('Look up').click() 
            .get('div').contains('A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.')
            
    })

    /**Validation 2 */
    it('search_pear', function () {
        cy
            .visit('/') 
            .get('.bodySearchWrap').type('pear')
            .get('input[type="submit"]').contains('Look up').click() 
            .get('div').contains('An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.')
            .first()
    })


})