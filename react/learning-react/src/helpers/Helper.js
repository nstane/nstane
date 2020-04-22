export const onClickScrollToTarget = (refElement) => {
    if (refElement && typeof refElement.scrollIntoView === 'function') {
      refElement.scrollIntoView({
        block: 'start',
        behavior: 'smooth'
      });
    }
};

export const StickyHelper = (context) => {
  let scrolEvent = undefined;
  return {
      resisterScrollEvent : () => {
      const windowHeight = window.innerHeight || document.documentElement.clientHeight;
       scrolEvent = (event) => {
         if(context.listReference) {
            const elementBounding = context.listReference.getBoundingClientRect();
            const stickyhidden = elementBounding.top >= windowHeight;
            console.log(elementBounding.top, elementBounding.bottom, windowHeight, stickyhidden)
            context.setState({stickyhide: stickyhidden});
          }
      };
      window.addEventListener('scroll', scrolEvent);
    },
    unResisterScrollEvent : ()=> {
      if(scrolEvent) {
        window.removeEventListener('scroll', scrolEvent);
      }
    }
  }
}
  