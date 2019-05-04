using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class StateGroup
    {
        [Key]
        public int stateGroupID { get; set; }


        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Estado de la ficha")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("StateGroup_nameState_Index", IsUnique = true)]
        public String nameState { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [MaxLength(30), MinLength(1)]
        [Display(Name = "Estado de la ficha")]
        public String toUpper
        {
            get
            {
                if (nameState != null)
                {
                    nameState = nameState.ToUpper();
                }
                else
                {
                    nameState = "Es requerido.";
                }
                return nameState;
            }
            set
            {
                if (nameState != null)
                {
                    nameState = nameState.ToUpper();
                }
                else
                {
                    nameState = "Es requerido.";
                }
                nameState.ToUpper();
           }
        }

        public virtual ICollection<Group> group { get; set; }
     
    }
}